import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import React from 'react';

// Simple logger utility
const logger = {
  info: (...args) => { console.info('[INFO]', ...args); },
  error: (...args) => { console.error('[ERROR]', ...args); },
  debug: (...args) => { console.debug('[DEBUG]', ...args); }
};

// Error Boundary for catching render errors
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null };
  }
  static getDerivedStateFromError(error) {
    return { hasError: true, error };
  }
  componentDidCatch(error, errorInfo) {
    logger.error('Render error:', error, errorInfo);
  }
  render() {
    if (this.state.hasError) {
      return <div style={{color: 'red'}}>Something went wrong: {this.state.error && this.state.error.toString()}</div>;
    }
    return this.props.children;
  }
}

function App() {
  const [message, setMessage] = useState('');
  const [cast, setCast] = useState([]);

  const fetchHello = async () => {
    logger.debug('[WORKFLOW] Entered fetchHello()');
    try {
      const response = await fetch('/api/hello');
      const text = await response.text();
      setMessage(text);
      logger.info('Fetched hello message:', text);
    } catch (error) {
      logger.error('Error in fetchHello():', error);
      setMessage('Error connecting to backend');
    } finally {
      logger.debug('[WORKFLOW] Exiting fetchHello()');
    }
  };

  const fetchCast = async () => {
    logger.debug('[WORKFLOW] Entered fetchCast()');
    try {
      const response = await fetch('/api/cast');
      if (!response.ok) throw new Error('Failed to fetch cast');
      const data = await response.json();
      setCast(data);
      logger.info('Fetched cast data:', data);
    } catch (error) {
      logger.error('Error in fetchCast():', error);
      setCast([{ name: 'Error fetching cast', firstAppearance: '' }]);
    } finally {
      logger.debug('[WORKFLOW] Exiting fetchCast()');
    }
  };

  return (
    <ErrorBoundary>
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <button onClick={fetchHello} style={{margin: '20px', padding: '10px 20px'}}>Say Hello (Backend)</button>
          <button onClick={fetchCast} style={{margin: '20px', padding: '10px 20px'}}>Show MCU Cast</button>
          {message && <p>{message}</p>}
          {cast.length > 0 && (
            <div style={{marginTop: '20px'}}>
              <h3>MCU Cast and First Appearance</h3>
              <ul style={{textAlign: 'left'}}>
                {cast.map((member, idx) => (
                  <li key={idx}><b>{member.name}</b>: {member.firstAppearance}</li>
                ))}
              </ul>
            </div>
          )}
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    </ErrorBoundary>
  );
}

export default App;

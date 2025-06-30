import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const [message, setMessage] = useState('');
  const [cast, setCast] = useState([]);

  const fetchHello = async () => {
    try {
      const response = await fetch('/api/hello');
      const text = await response.text();
      setMessage(text);
    } catch (error) {
      setMessage('Error connecting to backend');
    }
  };

  const fetchCast = async () => {
    try {
      const response = await fetch('/api/cast');
      if (!response.ok) throw new Error('Failed to fetch cast');
      const data = await response.json();
      setCast(data);
    } catch (error) {
      setCast([{ name: 'Error fetching cast', firstAppearance: '' }]);
    }
  };

  return (
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
  );
}

export default App;

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const [message, setMessage] = useState('');

  const fetchHello = async () => {
    try {
      const response = await fetch('/api/hello');
      const text = await response.text();
      setMessage(text);
    } catch (error) {
      setMessage('Error connecting to backend');
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <button onClick={fetchHello} style={{margin: '20px', padding: '10px 20px'}}>Say Hello (Backend)</button>
        {message && <p>{message}</p>}
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

const WebSocket = require('ws');

const client = new WebSocket('ws://localhost:8080');

client.on('open', () => {
  console.log('Connected to server');

  // Send a message to the server
  client.send('Hello, Server!');
});

client.on('message', (message) => {
  console.log(`Received from server: ${message}`);
});

client.on('close', () => {
  console.log('Disconnected from server');
});

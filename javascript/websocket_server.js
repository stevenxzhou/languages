const WebSocket = require('ws');

const server = new WebSocket.Server({ port: 8080 });

server.on('connection', (socket) => {
  console.log('Client connected');

  // Handle incoming messages from the client
  socket.on('message', (message) => {
    console.log(`Received: ${message}`);

    // Send a response back to the client
    socket.send(`Echo: ${message}`);
  });

  // Handle client disconnection
  socket.on('close', () => {
    console.log('Client disconnected');
  });
});

console.log('WebSocket server is running on ws://localhost:8080');

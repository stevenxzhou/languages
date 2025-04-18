const jwt = require('jsonwebtoken');

const token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NDMzMDgzMDYsImV4cCI6MTc0MzMxMTkwNiwiaXNzIjoidXNlcjEyMyJ9.0L3ETkXhihpd8oO10nmjco4iOkEy5x-vanMVRkrh-vI";
const secret = "my-secret";

try {
  const decoded = jwt.verify(token, secret);
  console.log("Token is valid:", decoded);
} catch (err) {
  console.error("Invalid token:", err.message);
}

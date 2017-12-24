module.exports = function a(req, res) {
  res.end(JSON.stringify({
    success: true,
    loginUser: {
      username: 'Jack'
    },
  }));
};



var http = require('http');
var fs = require('fs');

http.createServer(function (req, res) {
  if (req.url === '/appendfile1') {
    fs.appendFile('mynewfile1.txt', 'Hello content!', function (err) {
      if (err) throw err;
      console.log('Data appended to mynewfile1.txt');
    });
  } else if (req.url === '/openfile2') {
    fs.open('mynewfile2.txt', 'w', function (err, file) {
      if (err) throw err;
      console.log('File opened and data written to mynewfile2.txt');
    });
  } else if (req.url === '/writefile3') {
    fs.writeFile('mynewfile3.txt', 'Hello content!', function (err) {
      if (err) throw err;
      console.log('Data written to mynewfile3.txt');
    });
  } else if (req.url === '/appendfile1update') {
    fs.appendFile('mynewfile1.txt', ' This is my text.', function (err) {
      if (err) throw err;
      console.log('Data appended to mynewfile1.txt (updated)');
    });
  } else if (req.url === '/writefile3replace') {
    fs.writeFile('mynewfile3.txt', 'This is my text', function (err) {
      if (err) throw err;
      console.log('Data replaced in mynewfile3.txt');
    });
  } else if (req.url === '/deletefile2') {
    fs.unlink('mynewfile2.txt', function (err) {
      if (err) throw err;
      console.log('File mynewfile2.txt deleted');
    });
  } else if (req.url === '/renamefile1') {
    fs.rename('mynewfile1.txt', 'myrenamedfile.txt', function (err) {
      if (err) throw err;
      console.log('File mynewfile1.txt renamed to myrenamedfile.txt');
    });
  } else {
    // Handle unknown routes or return a custom 404 response if needed.
  }
}).listen(8080);
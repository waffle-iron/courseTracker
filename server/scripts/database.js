var mysql = require('mysql');
var connection = mysql.createConnection({
  host      : '45.55.250.253',
  user      : 'testuser',
  password  : '',
  database  : 'courses'
})

connection.connect();

connection.query('SELECT * FROM courses.courses', function(error, rows, fields){
  if (! error) {
    console.log('RESULT: ', rows);
  } else {
    console.log('Error while executing query');
  }
});

connection.end();

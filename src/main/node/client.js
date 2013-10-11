var thrift = require('thrift'),
  Calculator = require('./gen-nodejs/Calculator'),
  ttypes = require('./gen-nodejs/hello_types');

var connection = thrift.createConnection("localhost", 9090),
    client = thrift.createClient(Calculator, connection);

connection.on('error', function(err) {
  console.error(err);
});

var work = new ttypes.Work({num1: 1, num2: 30, op: ttypes.Operation.ADD, comment: 'i am client.'});

client.add(work, function(err, data) {
  if (err) {
    console.log(err);
  } else {
    console.log(data);
  }
  connection.end();
});
//var ReactDom = require('react-dom');
var ReactDom = require('react-dom');
var React= require('react');

var Twitter = require('./components/Twitter.react');

ReactDom.render(
  <Twitter />,
  document.getElementById('#timeline')
);



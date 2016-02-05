var React = require('react');

var Tweet = React.createClass({
  render: function() {
    return (
      <div className="panel panel-default">
        <div className="panel-heading">{this.props.username}</div>
        <div className="panel-body">{this.props.text}</div>
      </div>
    );
  }
});

module.exports = Tweet;
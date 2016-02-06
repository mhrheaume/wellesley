var React = require('react');

var Tweet = React.createClass({
  render: function() {
    return (
      <div className="panel panel-default">

        <div className="panel-heading"><img src={this.props.profpic}/> {this.props.username}</div>
        <div className="panel-body">{this.props.text}</div>
        <div className="panel-body"><img src={this.props.retweet} width="100"/></div>
      </div>
    );
  }
});

module.exports = Tweet;
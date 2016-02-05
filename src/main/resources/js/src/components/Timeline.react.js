var React = require('react');

var Tweet = require('./Tweet.react');

var Timeline = React.createClass({
  render: function() {
    var tweets = [];
    this.props.tweets.forEach(function(tweet) {
      tweets.push(<Tweet key={tweet.id} {...tweet} />)
    });

    return (<div>{tweets}</div>);
  }
});

module.exports = Timeline;
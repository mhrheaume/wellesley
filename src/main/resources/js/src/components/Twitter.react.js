var React = require('react');

var Timeline = require('./Timeline.react');
var TwitterActions = require('../actions/TwitterActions');
var TweetStore = require('../stores/TweetStore');

var Twitter = React.createClass({
  getInitialState: function() {
    return this.getState();
  },

  getState: function() {
    return {
      tweets: TweetStore.getAll()
    };
  },

  componentDidMount: function() {
    TwitterActions.loadUserTimeline();
    TweetStore.addChangeListener(this.onChange);
  },

  componentWillUnmount: function() {
    TweetStore.removeChangeListener(this.onChange);
  },

  render: function() {
    return (<Timeline tweets={this.state.tweets} />);
  },

  onChange: function() {
    this.setState(this.getState());
  }
});

module.exports = Twitter;
var assign = require('object-assign');
var AppDispatcher = require('../dispatcher/AppDispatcher');
var EventEmitter = require('events').EventEmitter;
var TwitterConstants = require('../constants/TwitterConstants');

var CHANGE_EVENT = 'CHANGE';

var tweets = [];

var TweetStore = assign({}, EventEmitter.prototype, {
  /**
   * Get all tweets
   */
  getAll: function() {
    return tweets;
  },

  /**
   * Trigger registered change callbacks
   */
  emitChange: function() {
    this.emit(CHANGE_EVENT);
  },

  /**
   * Add callback for a change event
   *
   * @param {function} callback
   */
  addChangeListener: function(callback) {
    this.on(CHANGE_EVENT, callback);
  },

  /**
   * Remove callback for a change event
   *
   * @param {function} callback
   */
  removeChangeListener: function(callback) {
    this.removeListener(CHANGE_EVENT, callback);
  }
});

AppDispatcher.register(function(action) {
  switch(action.actionType) {
    case TwitterConstants.TWEET_RESPONSE:
      tweets = action.tweets;
      TweetStore.emitChange();
      break;
  }
});

module.exports = TweetStore;
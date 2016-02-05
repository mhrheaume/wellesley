var AppDispatcher = require('../dispatcher/AppDispatcher');
var TwitterConstants = require('../constants/TwitterConstants');

var TwitterActions = {
  loadUserTimeline: function() {
    $.get({
      url: "/vine", // TODO: MATT CHANGE THIS
      dataType: "json",
      success: function(data) {
        AppDispatcher.dispatch({
          actionType: TwitterConstants.TWEET_RESPONSE,
          tweets: data.map(function(elem) {
            return {
              id: elem.id,
              username: elem.username,
              text: elem.text
            };
          })
        })
      }
    });
  }
};

module.exports = TwitterActions;

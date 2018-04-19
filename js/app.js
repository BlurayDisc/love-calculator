var AppView = Backbone.View.extend({
  id: "app",

  events: {
    "click #calculate": "calculate"
  },

  initialize: function() {
    this.removeErrors();
  },

  calculate: function(e) {
    //TODO display and hide spinners.
    var personA = $("#personA").val();
    personA = personA.trim();

    var personB = $("#personB").val();
    personB = personB.trim();

    this.removeErrors();
    if (!this.checkInput(personA, personB)) {
      return;
    }

    console.log("Calculating score for: ", personA, personB);
    var self = this;
    self.showSpinner();
    findOne(personA, personB)
      .done(function(data) {
        if (!_.isEmpty(data)) {
          console.log("Retrieved score from history for: ", personA, personB);
          self.displayResult(personA, personB, data);
        } else {
          console.log("Calculating new score for: ", personA, personB);
          data = calculate(personA, personB);
          self.displayResult(personA, personB, data);
        }
      })
      .always(function() {
        self.hideSpinner();
      });
  },

  displayResult: function(personA, personB, data) {
    var result = new Result({
      personA: personA,
      personB: personB,
      love: data.loveScore
    });
    var resultView = new ResultView({
      el: "#result",
      model: result
    });
  },

  removeErrors: function() {
    $("#personA-alert")
      .addClass("out")
      .removeClass("in");
    $("#personB-alert")
      .addClass("out")
      .removeClass("in");
  },

  checkInput: function(personA, personB) {
    if (!personA) {
      this.addError("personA", "Please fill out your name.");
      return false;
    }

    if (!personB) {
      this.addError("personB", "Please fill out your other half's name.");
      return false;
    }
    return true;
  },

  addError: function(name, message) {
    var field = "#" + name + "-alert";
    $(field).show();
    $(field)
      .addClass("in")
      .removeClass("out");
    $(field).text(message);
  },

  showSpinner: function() {
    $("#calculate").hide();
    $("#spinner").show();
  },
  hideSpinner: function() {
    $("#calculate").show();
    $("#spinner").hide();
  }
});

var app = new AppView({
  el: ".container"
});

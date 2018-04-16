var AppView = Backbone.View.extend({
  id: "app",

  events: {
    "click #calculate": "calculate"
  },

  initialize: function() {
    this.removeErrors();
  },

  calculate: function(e) {
    this.removeErrors();
    if (!this.checkInput()) {
      return;
    }

    var personA = $("#personA").val();
    var personB = $("#personB").val();
    var result = calculate(personA, personB);

    var result = new Result({
      personA: personA,
      personB: personB,
      love: result
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

  checkInput: function() {
    if (!$("#personA").val()) {
      this.addError("personA", "Please fill out your name.");
      return false;
    }
    if (!$("#personB").val()) {
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
  }
});

var app = new AppView({
  el: ".container"
});

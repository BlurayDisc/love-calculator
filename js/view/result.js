var Result = Backbone.Model.extend({
  initialize: function(attributes) {
    if (!attributes.personA || !attributes.personB || !attributes.love) {
      throw "Cannot initialise result model";
    }
  }
});

var ResultView = Backbone.View.extend({
  id: "result",
  className: "result",
  template: _.template($("#resultTemplate").html()),

  initialize: function() {
    this.render();
  },

  render: function() {
    this.$el.html(this.template(this.model.toJSON()));
  }
});

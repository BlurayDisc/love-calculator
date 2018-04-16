var Couple = Backbone.Model.extend({
    url : '/couples'
});

var CalculatorView = Backbone.View.extend({

    id : 'calculator',
    className : 'calculator',
    template : _.template($('#resultTemplate').html()),

    initialize : function() {
        this.listenTo(this.model, 'change', this.render);
    },

    render : function() {
        this.$el.html(this.template(this.model.toJSON()));
    },

    calculate : function() {

        var self = this;

        this.model.url = '/calculate';
        return this.model.save();
    }
});

var AppView = Backbone.View.extend({

    id : 'app',

    events : {
        'click #calculate' : 'calculate'
    },

    initialize : function() {

        this.removeErrors();
    },

    calculate : function(e) {

        var self = this;

        self.removeErrors();

        var couple = new Couple({
            personA : $('#personA').val(),
            personB : $('#personB').val()
        });

        var calculator = new CalculatorView({
            el : '#result',
            model : couple
        });

        calculator.calculate().done(function() {
            
        }).fail(function(error) {
            console.log(error.responseJSON)
            if (error.status == 400) {
                self.addErrors(error.responseJSON.errors);
            }
        });
    },

    removeErrors : function() {
        $('#personA-alert').addClass('out').removeClass('in');
        $('#personB-alert').addClass('out').removeClass('in');
    },

    addErrors : function(errors) {
        for (var i = 0; i < errors.length; i++) {
            var error = errors[i];
            var field = '#' + error.field + '-alert';
            var message = error.defaultMessage;
            $(field).show();
            $(field).addClass('in').removeClass('out');
            $(field).text(message);
        }
    }
});

var appView = new AppView({
    el : '.container'
});
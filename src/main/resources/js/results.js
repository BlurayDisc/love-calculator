var ResultsView = Backbone.View.extend({

    id : 'results',

    initialize : function() {

        // create table
        $('#results-table').DataTable({

            ajax : {
                url : '/couples',
                dataSrc : ''
            },

            columns : [
                {
                    data : 'personA'
                },
                {
                    data : 'personB'
                },
                {
                    data : 'love'
                }
            ]
        });
    }
});

var resultsView = new ResultsView({
    el : '.container'
});
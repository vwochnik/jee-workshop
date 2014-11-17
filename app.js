(function($, JSON, localStorage) {
  'use strict';

  var states = ['open', 'revision', 'closed'];
  var classes = ['text-danger glyphicon-unchecked', 'text-warning glyphicon-edit', 'text-success glyphicon-check'];

  $(function() {
    $('.panel:has(.task-checker)').each(function() {
      var $panel = $(this),
          $checker = $panel.find('.task-checker'),
          checkerId = $checker.attr('id');

      function load() {
        var state = states.indexOf(localStorage.getItem(checkerId));
        if (state < 0) state = 0;
        set(state);
      }

      function set(state) {
        $checker.data("state", state);
        for (var i = 0; i < states.length; i++) {
          $checker.addClass('glyphicon').toggleClass(classes[i], i===state);
        }
      }

      function save(state) {
        localStorage.setItem(checkerId, states[state]);
      }

      $checker.on('click', function() {
        var state = $checker.data('state');
        state = (state + 1) % states.length;
        set(state);
        save(state);
      });

      load();
    });
  });
})(jQuery, JSON, localStorage);

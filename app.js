(function($, JSON, localStorage) {
  'use strict';

  var store, $checkboxes, lastOpen;

  $(function() {
    $('#accordion .panel:has(.task-checker)').each(function() {
      var $panel = $(this),
          $checker = $panel.find('.task-checker');

      function set(value) {
          if ((value!=='open')&&(value!=='working')&&(value!=='closed'))
              value = 'open';
          $checker.data('value', value);
          $checker.addClass('glyphicon')
              .toggleClass('glyphicon-unchecked', (value==='open'))
              .toggleClass('text-danger', (value==='open'))
              .toggleClass('glyphicon-edit', (value==='working'))
              .toggleClass('text-warning', (value==='working'))
              .toggleClass('glyphicon-check', (value==='closed'))
              .toggleClass('text-success', (value==='closed'));
          return value;
      }

      function save(value) {
          localStorage.setItem($checker.attr('id'), set(value));
      }

      $checker.on('click', function() {
          var value = $checker.data('value');
          if (value==='open') { save('working'); }
          else if (value==='working') { save('closed'); }
          else { save('open'); }
      });

      set(localStorage.getItem($checker.attr('id')));
    });

    $('#accordion .collapse').on('show.bs.collapse', function() {
      lastOpen = '#'+$(this).attr('id');
      localStorage.setItem('lastOpen', lastOpen);
    });

    if ((lastOpen = localStorage.getItem('lastOpen')) !== undefined) {
      if (!$(lastOpen).hasClass('in')) {
        $('#accordion .collapse').removeClass('in');
        $(lastOpen).addClass('in');
      }
    }
  });
})(jQuery, JSON, localStorage);

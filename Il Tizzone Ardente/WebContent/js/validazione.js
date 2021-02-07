// Disattiva la sottomissione della form se ci sono campi non validi
(function() {
  'use strict';

  window.addEventListener('load', function() {
    // Prende le form alle quali vogliamo aggiungere lo style validation
    var forms = document.getElementsByClassName('needs-validation');
    // Le iteriamo tutte
    var validation = Array.prototype.filter.call(forms, function(form) {
    	// Aggiunge un evento 'submit'
      form.addEventListener('submit', function(event) {
    	// verifica se gli elementi input delle form hanno l'attributo pattern 'required' 
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();




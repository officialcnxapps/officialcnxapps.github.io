/**
 * wiki-lightbox.js
 * Shared lightbox for all wiki table images.
 */
(function () {
  // Create modal element
  var modal = document.createElement('div');
  modal.className = 'wiki-img-modal';
  modal.innerHTML = '<img src="" alt="">';
  document.body.appendChild(modal);

  var modalImg = modal.querySelector('img');

  // Close on click
  modal.addEventListener('click', function () { modal.classList.remove('open'); });

  // Open on table image click (event delegation)
  document.addEventListener('click', function (e) {
    var img = e.target.closest('.wiki-table .td-img img');
    if (!img || img.style.display === 'none') return;
    modalImg.src = img.src;
    modalImg.alt = img.alt;
    modal.classList.add('open');
  });

  // Close on Escape
  document.addEventListener('keydown', function (e) {
    if (e.key === 'Escape') modal.classList.remove('open');
  });
})();

window.addEventListener('load', function() {
    var img = document.getElementById('img');
    var xhr = new XMLHttpRequest();
    xhr.open('GET', img.src, true);
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
        var svgString = xhr.responseText;
        var parser = new DOMParser();
        var svgDoc = parser.parseFromString(svgString, 'image/svg+xml');
        var svgElement = svgDoc.querySelector('svg');
        svgElement.setAttribute('fill', 'currentColor');
        img.src = "data:image/svg+xml;charset=utf-8," + encodeURIComponent(svgDoc.documentElement.outerHTML);
      }
    };
    xhr.send();
  });
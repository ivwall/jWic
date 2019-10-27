{
	/**
	 * Invoked before the element is updated.
	 */ 
	beforeUpdate: function() {
    	alert("AudioController beforeUpdate");
	},
	
	/**
	 * Invoked when the element needs to be updated. If this function returns
	 * false, the existing HTML element is replaced by the rendered part that
	 * comes from the server. If the script is doing the update, it should return
	 * true, to prevent the update.
	 */
	doUpdate: function(element) {
    	alert("AudioController doUpdate");
	},

	/**
	 * Invoked after the DOM element was updated. This function is NOT updated if
	 * the custom doUpdate function returned true.
	 */
    afterUpdate: function ButtonAfterUpdate(){
    	alert("AudioController afterUpdate");
    	var mediaElements = document.querySelectorAll('video, audio'), i, total = mediaElements.length;
    	alert("AudioController afterUpdate media total "+total);
   		for (i = 0; i < total; i++) {
   			new MediaElementPlayer(mediaElements[i], {
			stretching: stretching,
			pluginPath: '../build/',
			success: function (media) {
				var renderer = document.getElementById(media.id + '-rendername');

				media.addEventListener('loadedmetadata', function () {
					var src = media.originalNode.getAttribute('src').replace('&amp;', '&');
					if (src !== null && src !== undefined) {
						renderer.querySelector('.src').innerHTML = '<a href="' + src + '" target="_blank">' + src + '</a>';
						renderer.querySelector('.renderer').innerHTML = media.rendererName;
						renderer.querySelector('.error').innerHTML = '';
					}
				});

				media.addEventListener('error', function (e) {
					renderer.querySelector('.error').innerHTML = '<strong>Error</strong>: ' + e.message;
				});
			}
		});
   		}
    },
	
	/**
	 * Invoked when the existing element is removed from the DOM tree.
	 */
	/***
	destroy: function(element) {
    	alert("AudioController destroy");
	}
	***/
}
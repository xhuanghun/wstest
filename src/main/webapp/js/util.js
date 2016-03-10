
function toFomatorString(date, formator) {
	var returnText = formator.toUpperCase();
	if (returnText.indexOf("YYYY") > -1) {
		returnText = returnText.replace("YYYY", date.getFullYear());
	}

	if (returnText.indexOf("MM") > -1) {
		returnText = returnText.replace("MM", date.getMonth() + 1);
	}

	if (returnText.indexOf("DD") > -1) {
		returnText = returnText.replace("DD", date.getDate());
	}

	if (returnText.indexOf("HH") > -1) {
		returnText = returnText.replace("HH", date.getHours());
	}

	if (returnText.indexOf("MI") > -1) {
		returnText = returnText.replace("MI", date.getMinutes());
	}

	if (returnText.indexOf("SS") > -1) {
		returnText = returnText.replace("SS", date.getSeconds());
	}

	if (returnText.indexOf("SI") > -1) {
		returnText = returnText.replace("SI", date.getMilliseconds());
	}

	return returnText;
}
if (!HTMLCanvasElement.prototype.toBlob) {
	  Object.defineProperty(HTMLCanvasElement.prototype, 'toBlob', {
	   value: function (callback, type, quality) {

	     var binStr = atob( this.toDataURL(type, quality).split(',')[1] ),
	         len = binStr.length,
	         arr = new Uint8Array(len);

	     for (var i=0; i<len; i++ ) {
	      arr[i] = binStr.charCodeAt(i);
	     }

	     callback( new Blob( [arr], {type: type || 'image/png'} ) );
	   }
	  });
	 }
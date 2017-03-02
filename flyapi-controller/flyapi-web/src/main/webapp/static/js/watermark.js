		function waterMark(){ 
			var mask_div = document.createElement('div');
			mask_div.id = 'mask_div1';
			mask_div.appendChild(document.createTextNode("http:www.flyapi.cn"));
			mask_div.style.position = "absolute";
			mask_div.style.right =  '20px';
			mask_div.style.bottom =  '10px';
			mask_div.style.overflow = "hidden";
			mask_div.style.zIndex = "9999";
			mask_div.style.opacity = 0.3;
			document.body.appendChild(mask_div);
		}
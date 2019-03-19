<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src='<c:url value = "/resources/common/js/jquery-3.3.1.js"/>'></script>
<script type="text/javascript"
	src='<c:url value = "/resources/common/js/bootstrap.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value = "/resources/common/js/bootstrap-datepicker.js" />'
	charset="UTF-8"></script>
<script>
	function setInputFilter(textbox, inputFilter) {
		[ "input", "keydown", "keyup", "mousedown", "mouseup", "select",
				"contextmenu", "drop" ].forEach(function(event) {
			textbox.addEventListener(event, function() {
				if (inputFilter(this.value)) {
					this.oldValue = this.value;
					this.oldSelectionStart = this.selectionStart;
					this.oldSelectionEnd = this.selectionEnd;
				} else if (this.hasOwnProperty("oldValue")) {
					this.value = this.oldValue;
					this.setSelectionRange(this.oldSelectionStart,
							this.oldSelectionEnd);
				}
			});
		});
	}
</script>
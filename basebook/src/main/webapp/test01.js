try {
	for (var lastpass_iter = 0; lastpass_iter < document.forms.length; lastpass_iter++) {
		var lastpass_f = document.forms[lastpass_iter];
		if (typeof (lastpass_f.lpsubmitorig2) == "undefined") {
			lastpass_f.lpsubmitorig2 = lastpass_f.submit;
			lastpass_f.submit = function() {
				var form = this;
				var customEvent = document.createEvent("Event");
				customEvent.initEvent("lpCustomEvent", true, true);
				var d = document.getElementById("hiddenlpsubmitdiv");
				if (d) {
					for (var i = 0; i < document.forms.length; i++) {
						if (document.forms[i] == form) {
							d.innerText = i;
						}
					}
					d.dispatchEvent(customEvent);
				}
				form.lpsubmitorig2();
			}
		}
	}
} catch (e) {
}


<iframe class="hidden_elem" name="transport_frame_8" src="/ajax/pagelet/generic.php/LitestandMoreStoriesPagelet?ajaxpipe=1&amp;ajaxpipe_token=AXjro9URkywPTIrC&amp;no_script_path=1&amp;data=%7B%22cursor%22%3A%22MTQxNjQ5NzYxMDoxNDE2NDk3NjEwOjE6LTgwMzA4NzQ3OTgzNzYyODU1ODY6MTQxNjQ5NzUwMjowOjA6NzIwMA%3D%3D%22%2C%22preload_next_cursor%22%3Anull%2C%22pager_config%22%3A%22%7B%5C%22edge%5C%22%3Anull%2C%5C%22source_id%5C%22%3Anull%2C%5C%22section_id%5C%22%3A408239535924329%2C%5C%22pause_at%5C%22%3Anull%2C%5C%22stream_id%5C%22%3Anull%2C%5C%22section_type%5C%22%3A1%2C%5C%22sizes%5C%22%3Anull%2C%5C%22most_recent%5C%22%3Afalse%2C%5C%22unread_session%5C%22%3Afalse%2C%5C%22continue_top_news_feed%5C%22%3Afalse%2C%5C%22ranking_model%5C%22%3Anull%2C%5C%22unread_only%5C%22%3Afalse%7D%22%2C%22pager_id%22%3A%22u_jsonp_7_2x%22%2C%22scroll_count%22%3A7%2C%22start_unread_session%22%3Afalse%2C%22start_continue_top_news_feed%22%3Afalse%2C%22feed_stream_id%22%3A56917504%2C%22snapshot_time%22%3Anull%7D&amp;__user=100003648892809&amp;__a=1&amp;__dyn=7n8anEyl2qm9udDgDxyF4EihUshEK49oKiqAEGmEZ9LFwxBxvyui9zpUgDyQqUkBBzEy6Kdy8-&amp;__req=jsonp_8&amp;__rev=1503785&amp;__adt=8"></iframe>
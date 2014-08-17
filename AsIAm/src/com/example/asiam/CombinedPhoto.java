package com.example.asiam;

import android.net.Uri;

public class CombinedPhoto {
	
	private Uri miniUri;
	private Uri fullUri;
	
	public CombinedPhoto(Uri miniUri, Uri fullUri) {
		this.miniUri = miniUri;
		this.fullUri = fullUri;
	}
	
	public Uri getMiniUri() {
		return miniUri;
	}
	public Uri getFullUri() {
		return fullUri;
	}
	public void setMiniUri(Uri miniUri) {
		this.miniUri = miniUri;
	}
	public void setFullUri(Uri fullUri) {
		this.fullUri = fullUri;
	}
}

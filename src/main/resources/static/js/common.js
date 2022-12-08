var bd = {};
bd.openWinPop = function( uri, width, height ) {
    if( this.windowRef != null ){
    this.closeWinPop();
    }

    let left = (screen.width) ? (screen.width - width) / 2 : 0;
    let top = (screen.height) ? (screen.height - height) / 2 : 0;

    let attr = 'top=' + top + ', left=' + left  + ', width=' + width + ', height=' + height + ', resizable=no,status=no';

    // 1. 윈도우 팝업 띄우기 
    this.windowRef = window.open(uri, "", attr);
    if( this.windowRef != null ) {
        this.windowRef.addEventListener('beforeunload', this.evtClose);
    }else{
        alert( "window.open fail!!!" );
    }

    // 2.  새로 띄운 윈도우 팝업창으로 부터 수신 메세지 이벤트 처리 
    window.addEventListener("message", this.recvEvtFromChild, false);
};

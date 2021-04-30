$(function() {
    var f_nBnrCnt = 0; // jQBanner�� ����ؼ� ȭ�鿡 ��µǴ� ���ʼ�

    $.f_varBanner = {
        defaults: {
            /* ���������� ���̴� ���� */
            objScr: null,   // ��ũ�� ����
            objBtn: null, // ��ư ����
            objTimer: null, // Ÿ�̸�
            nOrderNo: 999, // ���� ���õ� ���̾�
            nOrderNoBtn: -1, // ��ư ���ý� ���̾�

            /* �ʱ⼼���� ������  �ʼ� ���� */
            nWidth: 0, // ���� ��ũ�� ���� ��
            nHeight: 0, // ���� ��ũ�� ���� ����
            nCount: 0, // ���� ��ũ�� ������ �����ִ� ���̾��� ��
            isActType: "none",  // ���� �׼� Ÿ�� none,left,right,up,down,fade,page

            /* �ʱ⼼���� ������  �ɼ� ���� */
            isShuffle: "N", // ���� ���̾���� ���� ���� Y:����,N:������
            isBtnAct: "mouseover",  // ��ư �۵���� mouseover,click
            isBtnType: "img", // ��ư Ÿ�� img,li           
            nStartUp: 300, // ��ŸƮ �� ù ���̾��� FadeIn �ӵ�
            nDelay: 5000, // ������
            nSpeed: 500, // �׼ǽ��� �ӵ�
            nSpeedFade: 300, // ���̵� ���� �׼ǿ��� ��ư �۵��� �ӵ��� ������ [�ǵ��� ����]
            isStartFade:"Y", // ��ŸƮ FadeIn ȿ�� ���� [���α׷����� ��ũ���� Display:block ó���� ��� ���]
            isStartDelay:"N" // ��ŸƮ�� �����̸� ������ ���� [���ſ� �������� ��� �����̸� ������ �ʱ�ȭ]
        }
    };

    $.fn.jQBanner = function(defaults){
	    var config = $.extend({}, $.f_varBanner.defaults, defaults);
        var isIEChk = jsBrowserCheck();

        config.objScr = "#"+this.attr("id")+" .clsBannerScreen";
        config.objBtn = "#"+this.attr("id")+" .clsBannerButton";
        
        if (config.isStartDelay=="Y" && isIEChk==true) {
            /* ��ŸƮ ������ ó�� */
            if (f_nBnrCnt>=0 && f_nBnrCnt<=3) {
                setTimeout( function(){jsBanInit(config)}, f_nBnrCnt*100);
            } else if (f_nBnrCnt>3 && f_nBnrCnt<=6) {
                setTimeout( function(){jsBanInit(config)}, f_nBnrCnt*200);
            } else if (f_nBnrCnt>6 && f_nBnrCnt<=10) {
                setTimeout( function(){jsBanInit(config)}, f_nBnrCnt*300);
            } else if (f_nBnrCnt>10) {
                setTimeout( function(){jsBanInit(config)}, 400);
            }
            f_nBnrCnt++;
        } else {
            jsBanInit(config);
        }

        return this;
    };

    function jsBanInit(config) {
        var nPosFix;

        /* ���� ��ũ�� CSS ���� */
        $(config.objScr).css({'position':'relative','height':config.nHeight+'px','width':config.nWidth+'px','overflow':'hidden'});
        
        /* ù ���̾� ���� */
        config.nOrderNo = (config.nOrderNo==999) ? Math.floor(Math.random() * config.nCount):config.nOrderNo-1;

        /* �׼� Ÿ�Կ� ���� �ʱ� ���� */
        if (config.isActType == "left") {
            $(config.objScr+" div").each(function(i){
                nPosFix = (config.nOrderNo==i)?0:config.nWidth;
                $(this).css({'position':'absolute','top':'0','left':(-1*nPosFix)+'px'});
                if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                    $(this).fadeIn(config.nStartUp);
                }
                $(this).attr("divno",i);
            });
        } else if (config.isActType == "right") {
            $(config.objScr+" div").each(function(i){
                nPosFix = (config.nOrderNo==i)?0:config.nWidth;             
                $(this).css({'position':'absolute','top':'0','left':nPosFix+'px'});
                if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                    $(this).fadeIn(config.nStartUp);
                }
                $(this).attr("divno",i);
            });
        } else if (config.isActType == "up") {
            $(config.objScr+" div").each(function(i){
                nPosFix = (config.nOrderNo==i)?0:config.nHeight;
                $(this).css({'position':'absolute','top':(-1*nPosFix)+'px','left':'0'});
                if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                    $(this).fadeIn(config.nStartUp);
                }
                $(this).attr("divno",i);
            });
        } else if (config.isActType == "down") {
            $(config.objScr+" div").each(function(i){
                nPosFix = (config.nOrderNo==i)?0:config.nHeight;
                $(this).css({'position':'absolute','top':nPosFix+'px','left':'0'});
                if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                    $(this).fadeIn(config.nStartUp);
                }
                $(this).attr("divno",i);
            });
        } else if (config.isActType == "fade") {
            $(config.objScr+" div").each(function(i){
                if (config.nOrderNo==i) {
                    nPosFix = 0;
                    if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                        $(this).fadeIn(config.nStartUp);
                    }
                } else {
                    nPosFix = config.nWidth;
                }
                $(this).css({'position':'absolute','top':'0','left':nPosFix+'px'});
                $(this).attr("divno",i);
            });
        } else if (config.isActType == "page") {
            $(config.objScr+" div").each(function(i){
                nPosFix = (config.nOrderNo==i)?0:config.nHeight;
                $(this).css({'position':'absolute','top':nPosFix+'px','left':'0'});
                if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                    $(this).fadeIn(config.nStartUp);
                }
                $(this).attr("divno",i);
            });
        } else if (config.isActType == "none") {
            $(config.objScr+" div").each(function(i){
                if (config.nOrderNo==i) {
                    nPosFix = 0;
                    if (!(config.nOrderNo==i && config.isStartFade=="N")) {
                        $(this).fadeIn(config.nStartUp);
                    }
                } else {
                    nPosFix = config.nWidth;
                }
                $(this).css({'position':'absolute','top':'0','left':nPosFix+'px'});
                $(this).attr("divno",i);
            });
        }

        /* ��ư ���� ���� */
        $(config.objBtn+" "+config.isBtnType).each(function(i){ $(this).attr("btnno",i); $(this).css("cursor","hand") });

        /* ��ư ���ε� */
        jsBanBtnBind(config);
        
        /* ��ũ�� pause ���ε� */
        jsScrPauseBind(config);

        /* ���� Ÿ�̸� ��� �� �׼� ����!!!! */
        if (config.isActType != "none" && config.isActType != "page") {
            config.objTimer = setTimeout( function(){jsBanTimer(config)}, config.nDelay);
        }
    };

    /* ��� Ÿ�̸� */
    function jsBanTimer(config) {
        /* ��ư �׼� ������ �ʱ�ȭ */
        config.nOrderNoBtn = -1;

        jsBanAction(config);
        config.objTimer = setTimeout( function(){jsBanTimer(config)}, config.nDelay);
    };

    /* ��� �׼� ó�� */
    function jsBanAction(config) {
        var nPageSel;
        var nSpeed = config.nSpeed;
        var nDivNoSel = config.nOrderNo;
        var nOrderNext = (config.nOrderNo+1)%(config.nCount);

        /* 'page' �׼��� ��� ���������� ���� */
        if (config.isActType == "page") {
            var nOrderMinus = config.nOrderNoBtn-config.nOrderNo;
            nPageSel = (nOrderMinus==1 || (nOrderMinus==(config.nCount-1)*-1)) ? 1 : 0;
        }   

        if (config.nOrderNoBtn >= 0) {
            config.nOrderNo = config.nOrderNoBtn;
            nOrderNext = config.nOrderNoBtn;
            nSpeed = (config.isActType=="fade" || config.isActType=="page" || config.isActType=="none") ? config.nSpeedFade : 0;
        } else {
            config.nOrderNo = ((config.nCount-1)==config.nOrderNo) ? nOrderNext : config.nOrderNo+1;
        }

        var nDivNoNext = nOrderNext;

        var objSelObj = $(config.objScr+" div[divno='"+nDivNoSel+"']");
        var objNextObj = $(config.objScr+" div[divno='"+nDivNoNext+"']");

        /* �׼ǿ� ���� ��ư ���� */
        if (config.isActType != "page") {
            jsBanBtnRO(config,nOrderNext);
        }

        /* ���� ��ũ�� ���̾���� ���� ó�� */
        if (config.isActType == "left") {
            objNextObj.css('left',(config.nWidth)+'px');
            objSelObj.animate({'left':(-1*config.nWidth)+'px'},nSpeed);
            objNextObj.animate({'left':'0'},nSpeed);
        } else if (config.isActType == "right") {
            objNextObj.css('left',(-1*config.nWidth)+'px');
            objSelObj.animate({'left':config.nWidth+'px'},nSpeed);
            objNextObj.animate({'left':'0'},nSpeed);
        } else if (config.isActType == "up") {
            objNextObj.css('top',config.nHeight+'px');
            objSelObj.animate({'top':(-1*config.nHeight)+'px'},nSpeed);
            objNextObj.animate({'top':'0'},nSpeed);
        } else if (config.isActType == "down") {
            objNextObj.css('top',(-1*config.nHeight)+'px');
            objSelObj.animate({'top':config.nHeight+'px'},nSpeed);
            objNextObj.animate({'top':'0'},nSpeed);
        } else if (config.isActType == "fade") {
            objSelObj.css({'left':config.nWidth+'px','display':'none'});
            objNextObj.css('left','0');
            objNextObj.fadeIn(nSpeed);
        } else if (config.isActType == "page") {
            if (nPageSel == 0) {
                objNextObj.css({'top':'0','left':config.nWidth+'px'});
                objSelObj.animate({'left':(-1*config.nWidth)+'px'},nSpeed);
                objNextObj.animate({'left':'0'},nSpeed);
            } else if (nPageSel == 1) {
                objNextObj.css({'top':'0','left':(-1*config.nWidth)+'px'});
                objSelObj.animate({'left':config.nWidth+'px'},nSpeed);
                objNextObj.animate({'left':'0'},nSpeed);
            }
        } else if (config.isActType == "none") {
            objSelObj.css({'left':config.nWidth+'px','display':'none'});
            objNextObj.css('left','0');
            objNextObj.fadeIn(nSpeed);
        }
    }

    /* ��ũ�� pause ���ε� */
    function jsScrPauseBind(config) {
        /* ��ũ���� ���� ó�� */
        $(config.objScr).mouseover(function(){
            clearTimeout(config.objTimer);
        });
        $(config.objScr).mouseout(function(){
            if (config.isActType != "none" && config.isActType != "page") {
                config.objTimer = setTimeout( function(){jsBanTimer(config)}, config.nDelay);
            }
        });     
    }
    
    /* ��ư ���ε� */
    function jsBanBtnBind(config) {
        /* �ʱ� ��ư ���� */
        if (config.isActType != "page") {
            jsBanBtnRO(config,config.nOrderNo);
        }
        
        /* ��ư�� ���� ���콺 ������ ��� ó�� */
        if (config.isBtnAct=="mouseover") {
            /* ��ư�� ���� ó�� */
            $(config.objBtn+" "+config.isBtnType).mouseover(function(){
                var nImgNo = $(this).attr("btnno");

                if (config.isActType != "none" && config.isActType != "page") {
                    clearTimeout(config.objTimer);
                }

                if (config.isActType == "page") {
                    if (nImgNo == 0) {
                        config.nOrderNoBtn = ((config.nOrderNo-1)<0) ? config.nCount-1 : config.nOrderNo-1;
                    } if (nImgNo == 1) {
                        config.nOrderNoBtn = ((config.nOrderNo+1)==config.nCount) ? (config.nOrderNo+1)%config.nCount : config.nOrderNo+1;
                    }
                    jsBanBtnRO(config,nImgNo);
                } else {
                    config.nOrderNoBtn = parseInt(nImgNo);
                }

                jsBanAction(config);
            });
            $(config.objBtn+" "+config.isBtnType).mouseout(function(){
                if (config.isActType != "none" && config.isActType != "page") {
                    config.objTimer = setTimeout( function(){jsBanTimer(config)}, config.nDelay);
                }
            });

        /* ��ư�� ���� Ŭ���� ��� ó�� */
        } else if (config.isBtnAct=="click") {
            $(config.objBtn+" "+config.isBtnType).click(function(){
                var nImgNo = $(this).attr("btnno");
                
                if (config.isActType != "none" && config.isActType != "page") {
                    clearTimeout(config.objTimer);
                }

                if (config.isActType == "page") {
                    if (nImgNo == 0) {
                        config.nOrderNoBtn = ((config.nOrderNo-1)<0) ? config.nCount-1 : config.nOrderNo-1;
                    } if (nImgNo == 1) {
                        config.nOrderNoBtn = ((config.nOrderNo+1)==config.nCount) ? (config.nOrderNo+1)%config.nCount : config.nOrderNo+1;
                    }
                    jsBanBtnRO(config,nImgNo);
                } else {
                    config.nOrderNoBtn = parseInt(nImgNo);
                }
                
                jsBanAction(config);

                if (config.isActType != "none" && config.isActType != "page") {
                    config.objTimer = setTimeout( function(){jsBanTimer(config)}, config.nDelay);
                }
            });
        }
    };

    /* ��ư �ѿ��� ó�� */
    function jsBanBtnRO (config,nSel) {
        if (config.isBtnType=="img") {
            $(config.objBtn+" img").each(function(i){
                if (nSel==i) {
                    $(this).attr("src",$(this).attr("oversrc"));
                } else {
                    $(this).attr("src",$(this).attr("outsrc"));
                }
            });
            
        } else if (config.isBtnType=="li") {
            $(config.objBtn+" li").each(function(i){
                if (nSel==i) {
                    $(this).attr("class",$(this).attr("overclass"));
                } else {
                    $(this).attr("class",$(this).attr("outclass"));
                }
            });
            
        }
    }

    /* IE üũ */
    function jsBrowserCheck() {
        appname = navigator.appName;
        useragent = navigator.userAgent;
    
        if(appname == "Microsoft Internet Explorer") appname = "IE";
        IE55 = (useragent.indexOf('MSIE 5.5')>0);  //5.5 ����
        IE6 = (useragent.indexOf('MSIE 6')>0);     //6.0 ����
        IE7 = (useragent.indexOf('MSIE 7')>0);     //7.0 ����
        IE8 = (useragent.indexOf('MSIE 8')>0);     //8.0 ����
    
        if(appname=="IE" && IE55 || IE6 || IE7 || IE8){
            return true
        }else{
            return false; 
        }
    }   
});
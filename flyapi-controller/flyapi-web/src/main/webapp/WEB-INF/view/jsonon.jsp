<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Json在线解析</title>
    <meta charset="utf-8" />
    <meta name="keywords" content="json,json在线解析,json格式化,json格式验证,json数组"/>
    <meta name="description" content="一款简洁优雅的在线json解析器，可能是目前最好用的json在线查看工具"/>
    <link href="<%=request.getContextPath()%>/static/jsonon/css/main.css" rel="stylesheet">
</head>
<body>

    <div id="app">
      <div class="side-left">
        <textarea  v-model="jsoncon" id="jsontxt"></textarea>
      </div>

      <div class="splitx"></div>

      <div class="side-right">
        <div class="right-inner">
          <div class="right-bar">
            <svg title="压缩" @click="compress()" v-bind:class="'icon active-' + (view == 'compress')">
              <use xlink:href="<%=request.getContextPath()%>/static/jsonon/svg/icon.svg#database"></use>
            </svg>

            <svg class="icon" title="全部展开" @click="expandAll()">
              <use xlink:href="<%=request.getContextPath()%>/static/jsonon/svg/icon.svg#expand"></use>
            </svg>

            <svg class="icon" title="全部折叠" @click="collapseAll()">
              <use xlink:href="<%=request.getContextPath()%>/static/jsonon/svg/icon.svg#collapse"></use>
            </svg>

            <svg class="icon" title="清空" @click="clearAll()">
              <use xlink:href="<%=request.getContextPath()%>/static/jsonon/svg/icon.svg#clear"></use>
            </svg>
			
          </div>
          <div class="right-main">

            <!--正常JSON格式化视图-->
            <div class="view-code"  v-show="view == 'code'">
              <vue-outer :jsondata="jsonhtml" isend="true"></vue-outer>
            </div>

            <!--空视图-->
            <div class="view-code"  v-show="view == 'empty'">
            </div>

            <!--格式化错误视图-->
            <div class="view-error" v-show="view == 'error'">
              <pre v-cloak>{{error.msg}}</pre>
            </div>

            <!--压缩视图-->
            <textarea v-show="view == 'compress'">{{compressStr}}</textarea>
            
          </div>
        </div>
      </div>

    </div>    

    <!--用于移动的时候遮住文本域 避免被选中-->
    <div class="widnow-cover">
    </div> 

    <!--最外层根结构-->
    <script type="text/x-template" id="outer-template">
      <ul class="json-item">
        <vue-val  :val="jsondata" :isend="isend"></vue-val>
      </ul>
    </script>


    <!--内层每个键值对-->
    <script type="text/x-template" id="item-template">
      <ul class="json-item">
        <vue-val :field="key" :val="val" :isend="index == objLength(jsondata) - 1" v-for="(val, key, index) in jsondata"></vue-val>
      </ul>
    </script>

    <!--key value 最终的渲染方式-->
    <script type="text/x-template" id="val-template">
      <div class="keyval">
        <template v-if="!isObjectArr(val)">
          <span class="key" v-show="field">"{{field}}": </span>
          <span  v-bind:class="'val val-' + getTyp(val)">
            <span v-if="!isaLink(val)">{{formatVal(val)}}</span>
            <a v-if="isaLink(val)" :href="val" target="_blank" class="json-link">{{formatVal(val)}}</a>
            <span v-if="!isend">,</span>
          </span>
        </template>


        <!--key + 展开折叠ICON-->
        <template v-if="isObjectArr(val)">
          <span class="key" v-show="field">"{{field}}": </span>
          <vue-expand></vue-expand>
        </template>


        <!--值为对象时-->
        <template v-if="getTyp(val) == 'Object'">
          <span class="expand-view">
            <span>{</span>
            <vue-item :jsondata="val"></vue-item>
            <div class="brace-end">}<span v-if="!isend">,</span></div>
          </span>  

          <span class="fold-view">{{getTyp(val)}}{<label class="ex-alia" @click="expand($event)">{{objLength(val)}}</label>}<span v-if="!isend">,</span></span>
        </template>


        <!--值为数组时-->
        <template v-if="getTyp(val) == 'Array'">
          <span class="expand-view">
            <span>[</span>
            <span class="val">
              <vue-outer :jsondata="sub" v-for="(sub, index) in val" :isend="index == val.length - 1"></vue-outer>
            </span> 
            <div class="brace-end">]<span v-if="!isend">,</span></div>
          </span>  

          <span class="fold-view">{{getTyp(val)}}[<label class="arrlen ex-alia" @click="expand($event)">{{val.length}}</label>]<span v-if="!isend">,</span></span>

        </template>
      </div>
    </script>

    
    <!--展开 折叠的 UI 组件-->
    <script type="text/x-template" id="expand-template">
      <span class="expand-wraper">
        <svg class="icon icon-square icon-square-min" @click="fold($event)" title="折叠">
          <use xlink:href="<%=request.getContextPath()%>/static/jsonon/svg/icon.svg#minus-square"></use>
        </svg>

        <svg class="icon icon-square icon-square-plus" @click="expand($event)" title="展开">
          <use xlink:href="<%=request.getContextPath()%>/static/jsonon/svg/icon.svg#plus-square"></use>
        </svg>
      </span>
    </script>

    

    <script src="<%=request.getContextPath()%>/static/jsonon/js/vue.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/jsonon/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/static/jsonon/js/jsonlint.js"></script>
    <script src="<%=request.getContextPath()%>/static/jsonon/js/parse.js"></script>
    <script src="<%=request.getContextPath()%>/static/jsonon/js/editor.js"></script>
    <script src="<%=request.getContextPath()%>/static/jsonon/js/main.js"></script>
    
    <!--访问统计  请换成自己的-->
    <script>
      var _hmt = _hmt || [];
      (function() {
/*         var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?0d088ec0e724b355417b09862c236ea8";
        var s = document.getElementsByTagName("script")[0]; 
        s.parentNode.insertBefore(hm, s); */
      })();
    </script>
</body>
</html>
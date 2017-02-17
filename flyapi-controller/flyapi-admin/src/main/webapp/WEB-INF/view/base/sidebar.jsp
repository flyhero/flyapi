<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

            <div class="navbar nav_title" style="border: 0;">
              <a href="#" class="site_title"><i class="fa fa-paper-plane"></i> <span>flyapi接口管理</span></a>
            </div>

            <div class="clearfix"></div>
            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="<%=request.getContextPath()%>${sessionScope.user.avatarUrl}" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${sessionScope.user.userName}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
            <hr>
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>………………………………</h3>
                <ul class="nav side-menu">
                  <li><a href="#"><i class="fa fa-home"></i> 首页</a>
                  </li>
                  <li><a><i class="fa fa-edit"></i> 我的项目 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu" id="user-project">
                      <li><a href="javascript:void(0);"  data-addtab="createProject" url="../forward/listCreatedProject.html">我创建的</a>
                      </li>
                      <li><a href="javascript:void(0);"  data-addtab="join" url="../forward/listJoinProject.html">我参与的</a>
                      </li>

                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i> 日志监控 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="javascript:void(0);"  data-addtab="druid" url="../druid">Druid连接池</a>
                      </li>
                      <li><a href="../forward/projects.html">服务器日志</a>
                      </li>
                      <li><a href="invoice.html">异常日志</a>
                      </li>

                    </ul>
                  </li>
                  <li><a><i class="fa fa-database"></i> 数据字典 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="javascript:void(0);"  data-addtab="database" url="../forward/data_base.html">数据库</a>
                      </li>
                      <li><a href="javascript:void(0);"  data-addtab="message" url="listCreatedProject.html">Table Dynamic</a>
                      </li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-bar-chart-o"></i> 数据分析 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="chartjs.html">注册量</a>
                      </li>
                      <li><a href="chartjs2.html">用户分布</a>
                      </li>

                    </ul>
                  </li>
                </ul>
              </div>
<!--               <div class="menu_section">
                <h3>Live On</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bug"></i> 添加页 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="e_commerce.html">E-commerce</a>
                      </li>
                      <li><a href="projects.html">Projects</a>
                      </li>
                      <li><a href="contacts.html">Contacts</a>
                      </li>
                      <li><a href="profile.html">Profile</a>
                      </li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="page_404.html">404 Error</a>
                      </li>
                      <li><a href="page_500.html">500 Error</a>
                      </li>
                      <li><a href="plain_page.html">Plain Page</a>
                      </li>
                      <li><a href="login.html">Login Page</a>
                      </li>
                      <li><a href="pricing_tables.html">Pricing Tables</a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </div> -->

            </div>
            <!-- /sidebar menu -->
                        <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a  data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a href="../user/logout.do" data-toggle="tooltip" data-placement="top" title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
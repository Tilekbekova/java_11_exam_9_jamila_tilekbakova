<#import "partials/main.ftlh" as main/>
<#import "/spring.ftl" as spring/>
<@main.renderWith>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="nav-link dropdown-toggle" href="http://localhost:8080"
               id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <@spring.message "main"></@spring.message>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                    aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:8080/register"><@spring.message "registration"></@spring.message></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"
                           href="http://localhost:8080/find"><@spring.message "search"></@spring.message></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://localhost:8080/login"
                           id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <@spring.message "login"></@spring.message>
                        </a>

                    </li>
                    <form action="" method="get">

                        <select name="lang" id="lang_select">
                            <option value="en">Us</option>
                            <option value="ru">Ru</option>
                        </select>
                        <button type="submit">
                            <@spring.message "change"></@spring.message>
                        </button>
                    </form>
                </ul>

            </div>
        </div>
    </nav>
    <form class="d-flex" role="search" method="get" action="/showTask" class="form-inline">
        <input type="text" name="id" class="form-control" value="${(products.id)!''}"
              />
        <input type="text" name="status" class="form-control" value="${(products.status)!''}"
             />
        <button type="submit"  value="" class="btn btn-primary ml-2"><@spring.message "change"></@spring.message></button>
    </form>




</@main.renderWith>

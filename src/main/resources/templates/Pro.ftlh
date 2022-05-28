<#import "partials/main.ftlh" as main />
<#import "/spring.ftl" as spring />
<@main.renderWith>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
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
    <form action="/pro" method="post" modelAttribute="pro">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">id:</p>
                <input type="text" name="cate" placeholder="cate" value="${(pro.cate)!''}">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">name:</p>
                <input type="text" name="name" placeholder="your name " value="${(dto.name)!''}">
            </label>
        </div>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">quantity:</p>
                <input type="text" name="quantity" placeholder="your quantity " value="${(pro.quantity)!''}">
            </label>
        </div>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">image:</p>
                <input type="text" name="image" placeholder="your image " value="${(pro.image)!''}">
            </label>
        </div>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">price:</p>
                <input type="text" name="price" placeholder="your price " value="${(pro.price)!''}">
            </label>
        </div>

        <div>
            <button type="submit">добавить</button>
        </div>
        <div>
            <#if errors?? >
                <p>Входные данные с ошибками!</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
            </#if>
        </div>
    </form>
    </div>
</@main.renderWith>

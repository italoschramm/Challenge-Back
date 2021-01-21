<template>
    <div>
        <div class="header-page">
            <div class="column1">
                <img class="logo-globo" src="../../../../src/images/logoGlobo.png" alt="logoGlobo">
            </div>
            <div class="column2">
                <img class="logo-globo" src="../../../../src/images/logoGlobo.png" alt="logoGlobo">
            </div>
        </div>
    </div>
</template>

<script>

    export default{

    }

</script>

<style scoped>

    .header-page{
         height: 44px;
         background-color: rgb(243, 243, 243);
    }

    .logo-globo{
        width: 74px;
        height: 18px;
    }

    .column1{
        width: 100px;
        height: 44px;
        display:table-cell; 
        vertical-align:middle; 
        text-align:center;
    }

</style>
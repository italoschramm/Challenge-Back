<template>
    <div class="vue-poll">
        <section>
            <h3>{{ titulo }}</h3>
            <li v-for='(op, i) of participant' :key='i' >
                <input type="radio"  value="0"><label>{{ op.name }}</label>
            </li>
            <br/>
        </section>
    </div> 
    
</template>

<script>
export default {
    props: {
            titulo: {
                type: String,
                required: true
            },
            participant: {
                type : Array
            }
    }
}
</script>

<style scoped>

</style>
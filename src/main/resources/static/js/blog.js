Vue.createApp({
    data() {
        return {
            title: '<b>Blog</b>',
            contents: '<b>this is Blog</b>',
            blogList: [],
            post: {
                title: "",
                contents: "",
            }
        };
    },
    mounted() {
        this.list();
    },
    methods: {
        list() {
            $.get('/blog/')
            .done( res => {
                this.blogList = res;
                this.blogList.forEach( row => row.created = row.created.substring(0,10));
            });
        },
        save() {
            $.post('/blog/save', this.post)
            .done( res => {
                this.post = { title: '', contents: '' };
                this.list();
            });
        },
        edit(row) {
            this.post = row;
        },
        remove( id ) {
            $.get('/blog/delete', { id: id })
            .done( res => { this.list() });
        }
    }
}).mount('#app');
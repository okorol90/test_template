package api;

public class Project {
        private Long id;
        private Integer order;
        private Integer color;
        private String name;
        private Integer comment_count;
        private Boolean shared;
        private Boolean favorite;
        private Integer sync_id;
        private String url;

        public Project(Integer color, String name) {
                this.color = color;
                this.name = name;
        }

        public Project() {}

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Integer getOrder() {
                return order;
        }

        public void setOrder(Integer order) {
                this.order = order;
        }

        public Integer getColor() {
                return color;
        }

        public void setColor(Integer color) {
                this.color = color;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getComment_count() {
                return comment_count;
        }

        public void setComment_count(Integer comment_count) {
                this.comment_count = comment_count;
        }

        public Boolean getShared() {
                return shared;
        }

        public void setShared(Boolean shared) {
                this.shared = shared;
        }

        public Boolean getFavorite() {
                return favorite;
        }

        public void setFavorite(Boolean favorite) {
                this.favorite = favorite;
        }

        public Integer getSync_id() {
                return sync_id;
        }

        public void setSync_id(Integer sync_id) {
                this.sync_id = sync_id;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }
}

public abstract class Category {
    public abstract String getCategoryName();

    public static class Generic extends Category {
        private String categoryName;

        public Generic(String categoryName) {
            this.categoryName = categoryName;
        }

        @Override
        public String getCategoryName() {
            return categoryName;
        }
    }
}

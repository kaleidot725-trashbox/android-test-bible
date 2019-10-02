package kaleidot725.tests.room.list3_11_17

class RepositoryLocalDataSource(val db: AppDatabase) {
    fun insertAll(vararg repositories: Repository) {
        db.repositoryDao().insertAll(*repositories)
    }

    fun findByOwner(owner: String): List<Repository> {
        return db.repositoryDao().findByOwner(owner)
    }
}
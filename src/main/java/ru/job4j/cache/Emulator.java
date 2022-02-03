package ru.job4j.cache;


interface Emulator {

    DirFileCache emCacheDir(String dirFileCache);

    void loadCache(DirFileCache dirFileCache, String key);

    String putFIleFromCache(DirFileCache dirFileCache, String key);

}

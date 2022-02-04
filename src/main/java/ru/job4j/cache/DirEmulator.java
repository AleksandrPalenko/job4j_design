package ru.job4j.cache;

public class DirEmulator implements Emulator {
    @Override
    public DirFileCache emCacheDir(String dirFileCache) {
        return new DirFileCache(dirFileCache);
    }

    @Override
    public void loadCache(DirFileCache dirFileCache, String key) {
        dirFileCache.load(key);
    }

    @Override
    public String putFIleFromCache(DirFileCache dirFileCache, String key) {
        return dirFileCache.get(key);
    }

}

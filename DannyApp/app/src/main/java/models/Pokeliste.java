package models;

import java.util.List;

public class Pokeliste {

        public List<PokemonKort> data;
        public int page { get; set; }
        public int pageSize { get; set; }
        public int count { get; set; }
        public int totalCount { get; set; }
    }


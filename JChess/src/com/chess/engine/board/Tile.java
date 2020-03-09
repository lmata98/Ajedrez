package com.chess.engine.board;


import com.chess.engine.pieces.Piece;
import org.carrot2.shaded.guava.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;


public abstract class Tile {


    protected int tileCoordinate = 0;
    private static final Map<Integer, EmptyFile> EMPTY_TILES_CACHE = createAllPosibleEmptyTiles();

   private static Map<Integer,EmptyFile> createAllPosibleEmptyTiles() {
        final Map<Integer, EmptyFile> emptyFileMap = new HashMap<>();
        for(int i=0; i<BoardUtils.NUM_TILES;i++)
        {
            emptyFileMap.put(i,new EmptyFile(i));
        }

        return ImmutableMap.copyOf(emptyFileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece)
    {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

     private   Tile(final int tileCordinate){
        this.tileCoordinate = tileCordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();


    public static final class EmptyFile extends Tile{
        EmptyFile(final int coordinate)
        {
            super(coordinate);
        }
        @Override
        public boolean isTileOccupied()
        {
            return false;

        }

        @Override
        public Piece getPiece()
        {
            return null;
        }
    }

    public static final class OccupiedTile extends Tile
    {
      private final Piece pieceOnTile;
        OccupiedTile(int tileCoordinate, final Piece piecceOnTile)
        {
            super(tileCoordinate);
            this.pieceOnTile=piecceOnTile;

        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }

}

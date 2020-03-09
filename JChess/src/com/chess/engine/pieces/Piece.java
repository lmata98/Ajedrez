package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.Collection;

public abstract class Piece {

    protected final int piecePositions;
    protected final Alliance piecceAlliance;


    public Piece(final int piecePositions, final Alliance piecceAlliance) {
        this.piecePositions = piecePositions;
        this.piecceAlliance = piecceAlliance;
    }
    public Alliance getPieceAlliance()
    {
        return this.piecceAlliance;
    }
    public abstract Collection<Move> calculateLegalMoves(final Board board);


}

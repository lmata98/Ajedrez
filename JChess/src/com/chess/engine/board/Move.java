package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public abstract class Move {

    final Board board;
    final Piece piece;
    final int destinationCordinate;


  private   Move(final Board boar, final Piece piece, final int destinationCordinate) {
        this.destinationCordinate = destinationCordinate;
        this.board=boar;
        this.piece=piece;
    }

    public static final class MajorMove extends Move{

        public MajorMove(final Board boar, final Piece piece, final int destinationCordinate) {
            super(boar, piece, destinationCordinate);
        }
    }

    public static final class AttackMove extends Move
    {
        final Piece attackedPiece;
        public AttackMove(final Board boar, final Piece piece, final int attackedPiece, Piece attackedPiece1) {
            super(boar, piece, attackedPiece);
            this.attackedPiece = attackedPiece1;
        }
    }

}

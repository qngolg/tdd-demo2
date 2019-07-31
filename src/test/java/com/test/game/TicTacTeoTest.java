package com.test.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacTeoTest {

    private TicTacTeo ticTacTeo;

    @Before
    public void setup() {
        ticTacTeo = new TicTacTeo();
    }

    /**
     * 需求1 将棋子放在3*3的棋盘里面
     *
     * 测试1 放在X轴边界以外的地方，则引发RuntimeException异常 should_throw_exception_when_x_outside
     * 测试2 放在Y轴边界以外的地方，则引发RuntimeException异常 should_throw_exception_when_y_outside
     * 测试3 放在已经有棋子的地方，则引发RuntimeException异常 should_throw_exception_when_it_occupied
     *
     */

    /**
     * * 测试1 放在X轴边界以外的地方，则引发RuntimeException异常
     */
    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_x_outside() {
        ticTacTeo.play(5, 1);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_y_outside() {
        ticTacTeo.play(2, 5);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_it_occupied() {
        ticTacTeo.play(1, 1);
        ticTacTeo.play(1, 1);
    }


    /**
     * 需求2 X和O依次下棋，X先下
     * <p>
     * 测试1 玩家X先下 should_first_player_is_x_when_game_start
     * 测试2 如果上一次是X下的，接下来就是O下的 should_next_player_is_o_when_last_player_is_x
     * 测试3 如果上一次是O下的，接下来就是X下的 should_next_player_is_x_when_last_player_is_o
     */

    @Test
    public void should_first_player_is_x_when_game_start() {
        Assert.assertEquals('X', ticTacTeo.nextPlayer());
    }

    @Test
    public void should_next_player_is_o_when_last_player_is_x() {
        ticTacTeo.play(1, 1);
        Assert.assertEquals('O', ticTacTeo.nextPlayer());
    }

    @Test
    public void should_next_player_is_x_when_last_player_is_o() {
        ticTacTeo.play(1, 1);
        ticTacTeo.play(1, 2);
        Assert.assertEquals('X', ticTacTeo.nextPlayer());
    }


    /**
     * 需求3 获胜条件：最先在水平、垂直或对角线上将自己的3个棋子连起来的玩家获胜，如果不满足则无人获胜
     * 测试1 不满足获胜条件，无人获胜 should_return_no_winner
     * 测试2 在水平线上连成一条直线，获胜 should_return_winner_when_play_whole_horizontal_line
     * 测试3 在垂直线上连成一条直线，获胜 should_return_winner_when_play_whole_vertical_line
     * 测试4 在主对角线上连成一条直线，获胜 should_return_winner_when_play_main_diagonal_line
     * 测试4 在副对角线上连成一条直线，获胜 should_return_winner_when_play_other_diagonal_line
     */

    @Test
    public void should_return_no_winner() {
        Assert.assertEquals("No Winner", ticTacTeo.play(1, 1));
    }

    @Test
    public void should_return_winner_when_play_whole_horizontal_line() {
        ticTacTeo.play(1, 1);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(2, 1);
        ticTacTeo.play(3, 2);
        String result = ticTacTeo.play(3, 1);
        Assert.assertEquals("X is winner", result);
    }

    @Test
    public void should_return_winner_when_play_whole_vertical_line() {
        ticTacTeo.play(1, 1);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(2, 1);
        ticTacTeo.play(3, 2);
        String result = ticTacTeo.play(3, 1);
        Assert.assertEquals("X is winner", result);
    }

    @Test
    public void should_return_winner_when_play_main_diagonal_line() {
        ticTacTeo.play(1, 1);
        ticTacTeo.play(1, 2);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(3, 2);
        String result = ticTacTeo.play(3, 3);
        Assert.assertEquals("X is winner", result);
    }

    @Test
    public void should_return_winner_when_play_other_diagonal_line() {
        ticTacTeo.play(1, 3);
        ticTacTeo.play(1, 2);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(3, 2);
        String result = ticTacTeo.play(3, 1);
        Assert.assertEquals("X is winner", result);
    }


    /**
     * 需求4 把格子占满为平局
     * 测试1 所有格子占满为平局 should_return_draw_when_all_box_filled
     */

    @Test
    public void should_return_draw_when_all_box_filled() {
        ticTacTeo.play(1, 1);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(3, 3);
        ticTacTeo.play(2, 1);
        ticTacTeo.play(2, 3);
        ticTacTeo.play(3, 2);
        ticTacTeo.play(1, 2);
        ticTacTeo.play(1, 3);
        String result = ticTacTeo.play(3, 1);
        Assert.assertEquals("the result is draw", result);
    }
}

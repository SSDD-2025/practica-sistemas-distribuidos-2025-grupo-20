package com.example.footballmadrid;

import com.example.footballmadrid.models.*;
import com.example.footballmadrid.repositories.*;
import com.example.footballmadrid.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FootballMadridApplicationTests {

    @BeforeEach
    void setUp() {

    }
    //saving tests
    @Test
    void userSavingTest() {

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserModel userModel = Mockito.mock(UserModel.class);
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(userModel);
        UserService userService = new UserService(userRepository);

        Assertions.assertEquals(userModel,userService.save(userModel));
        Mockito.verify(userRepository,Mockito.times(1)).save(Mockito.any());
    }
    @Test
    void commentsSavingTest() {

        CommentRepository commentRepository = Mockito.mock(CommentRepository.class);
        CommentModel commentModel = Mockito.mock(CommentModel.class);
        Mockito.when(commentRepository.save(Mockito.any())).thenReturn(commentModel);
        CommentService commentService = new CommentService(commentRepository);

        Assertions.assertEquals(commentModel,commentService.save(commentModel));
        Mockito.verify(commentRepository,Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void PitchSavingTest() {
        PitchRepository pitchRepository = Mockito.mock(PitchRepository.class);
        PitchService pitchService = new PitchService(pitchRepository);
        PitchModel pitchModel = Mockito.mock(PitchModel.class);
        Mockito.when(pitchRepository.save(Mockito.any())).thenReturn(pitchModel);

        Assertions.assertEquals(pitchModel,pitchService.save(pitchModel));
        Mockito.verify(pitchRepository,Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void gamesSavingTest() {
        GameRepository gameRepository = Mockito.mock(GameRepository.class);
        GameModel gameModel = Mockito.mock(GameModel.class);
        Mockito.when(gameRepository.save(Mockito.any())).thenReturn(gameModel);
        GameService gameService = new GameService(gameRepository);

        Assertions.assertEquals(gameModel,gameService.save(gameModel));
        Mockito.verify(gameRepository,Mockito.times(1)).save(Mockito.any());
    }
    @Test
    void chatSavingTest() {
        ChatRepository chatRepository = Mockito.mock(ChatRepository.class);
        ChatModel chatModel = Mockito.mock(ChatModel.class);
        Mockito.when(chatRepository.save(Mockito.any())).thenReturn(chatModel);
        ChatService chatService = new ChatService(chatRepository);

        Assertions.assertEquals(chatModel,chatService.save(chatModel));
        Mockito.verify(chatRepository,Mockito.times(1)).save(Mockito.any());

    }
    @Test
    void messagesSavingTest() {
        MessageRepository messageRepository = Mockito.mock(MessageRepository.class);
        MessageModel messageModel = Mockito.mock(MessageModel.class);
        Mockito.when(messageRepository.save(Mockito.any())).thenReturn(messageModel);
        MessageService messageService = new MessageService(messageRepository);

        Assertions.assertEquals(messageModel,messageService.save(messageModel));
        Mockito.verify(messageRepository,Mockito.times(1)).save(Mockito.any());

    }
}

package com.example.notessampleapp.di

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.example.notessampleapp.feature_note.data.data_source.NoteDatabase
import com.example.notessampleapp.feature_note.data.repository.NoteRepositoryImplementation
import com.example.notessampleapp.feature_note.domain.repository.NoteRepository
import com.example.notessampleapp.feature_note.domain.use_case.AddNote
import com.example.notessampleapp.feature_note.domain.use_case.DeleteNote
import com.example.notessampleapp.feature_note.domain.use_case.GetNotes
import com.example.notessampleapp.feature_note.domain.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}